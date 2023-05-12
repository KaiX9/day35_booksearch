import { Injectable, inject } from "@angular/core";
import { Observable, Subject, tap } from "rxjs";
import { Book, Details } from "./models";
import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";

const URL_BOOK = 'http://localhost:8080/book'

@Injectable()
export class BookService {

    onType = new Subject<Book[]>()

    http = inject(HttpClient)

    // postTextAsForm(data: string): Observable<Book[]> {

    //     const form = new HttpParams()
    //         .set("text", data)

    //     const headers = new HttpHeaders()
    //         .set("Content-Type", "application/x-www-form-urlencoded")

    //     return this.http.post<Book[]>(URL_BOOK, 
    //         form.toString(), { headers: headers})
    //             // .pipe(
    //             //     tap(resp => this.onType.next(resp))
    //             // )
    // }

    postTextAsJSON(text: string): Observable<Book[]> {

        const book: Details = {
            title: text
        }
        
        return this.http.post<Book[]>(URL_BOOK, book)
    }

}