import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Task} from './model/task';
import {catchError} from 'rxjs/operators';
import {throwError} from 'rxjs';
import { environment } from '../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.less']
})
export class TaskComponent implements OnInit {
  task: string;
  title = 'todo-angular';
  tasks = [];

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get<Array<Task>>(environment.baseUrl)
      .subscribe(tasks => (this.tasks = tasks));
  }

  addTask() {
    if (this.task.trim()) {
      this.http.post<Task>(environment.baseUrl, new Task(this.task))
        .subscribe(newTask => {
          this.tasks.push(newTask);
          this.task = '';
        });
    }
  }

  updateTask(task: Task) {
    task.done = !task.done;
    this.http.put<Task>(environment.baseUrl, task)
      .pipe(catchError(() => {
        task.done = !task.done;

        return throwError(
          'Something bad happened; please try again later.');
      }))
      .subscribe();
  }
}
