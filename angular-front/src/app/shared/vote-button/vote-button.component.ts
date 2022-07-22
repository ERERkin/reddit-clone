import {Component, Input, OnInit} from '@angular/core';
import {faArrowDown, faArrowUp } from '@fortawesome/free-solid-svg-icons';
import { PostModel } from '../post-model';
import {AuthService} from "../../auth/shared/auth.service";
import {PostService} from "../post.service";
import {throwError} from "rxjs";
import {VotePayload} from "./vote-payload";
import {ToastrService} from "ngx-toastr";
import {VoteService} from "../vote.service";
import {VoteType} from "./vote-type";

@Component({
  selector: 'app-vote-button',
  templateUrl: './vote-button.component.html',
  styleUrls: ['./vote-button.component.css']
})
export class VoteButtonComponent implements OnInit {
  @Input() post: PostModel;
  votePayload: VotePayload;
  faArrowUp = faArrowUp;
  faArrowDown = faArrowDown;
  upvoteColor: string | undefined;
  downvoteColor: string | undefined;

  constructor(private voteService: VoteService,
              private authService: AuthService,
              private postService: PostService, private toastr: ToastrService) {
    // @ts-ignore
    this.post = {}

    // @ts-ignore
    this.votePayload = {}
  }

  ngOnInit(): void {
    this.updateVoteDetails();
  }

  upvotePost() {
    this.votePayload.voteType = VoteType.UPVOTE;
    this.vote();
    this.downvoteColor = '';
  }

  downvotePost() {
    this.votePayload.voteType = VoteType.DOWNVOTE;
    this.vote();
    this.upvoteColor = '';
  }

  private vote() {
    // @ts-ignore
    this.votePayload.postId = this.post.id;
    this.voteService.vote(this.votePayload).subscribe(() => {
      this.updateVoteDetails();
    }, error => {
      this.toastr.error(error.error.message);
      throwError(error);
    });
  }

  private updateVoteDetails() {
    // @ts-ignore
    this.postService.getPost(this.post.id).subscribe(post => {
      this.post = post;
    });
  }
}
