import { Component, OnInit, inject } from '@angular/core';
import { BookService } from './book.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Observable, Subject, debounceTime, filter, map, mergeMap } from 'rxjs';
import { Book } from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  bkSvc = inject(BookService)
  // fb = inject(FormBuilder)
  titleInput = new Subject<string>()
  // form!: FormGroup
  search$!: Observable<Book[]> 

  keyPressed(text: string) {
    console.info(">>> text: ", text)
    this.titleInput.next(text)
  }  

  ngOnInit(): void {
    this.search$ = this.titleInput.pipe(
      filter(text => text.trim().length > 0),
      mergeMap(text => this.bkSvc.postTextAsJSON(text))
    )
    // this.form = this.createForm()
    // this.search$ = this.titleInput.pipe(
    //   filter(title => title.trim().length > 0),
    //   mergeMap(title => this.bkSvc.postTextAsForm(title))
    // )
  }

  // private createForm(): FormGroup {
  //   return this.fb.group({
  //     text: this.fb.control('')
  //   })
  // }
  
}
