import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {SubredditModel} from "./subreddit-model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class SubredditService {

  constructor(private httpClient: HttpClient) { }

  getAllSubreddits(): Observable<Array<SubredditModel>> {
    return this.httpClient.get<Array<SubredditModel>>('http://localhost:8080/api/subreddit');
  }

  createSubreddit(subredditModel: SubredditModel): Observable<SubredditModel> {
    console.log(subredditModel.name)
    return this.httpClient.post<SubredditModel>('http://localhost:8080/api/subreddit',
      subredditModel);
  }
}
