import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EMPTY, Observable, catchError, throwError } from 'rxjs';


@Injectable()
export class Interceptor implements HttpInterceptor {

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // return next.handle(request).pipe(
    //   catchError((httpError: HttpErrorResponse) => {
    //     console.log(httpError);
    //     if (httpError instanceof HttpErrorResponse && httpError.status != 200) {
    //       alert(httpError.error);
    //     }
    //     return throwError(() => httpError);
    //   }));

    return next.handle(request).pipe(
      catchError((error: HttpErrorResponse) => {
        alert(error.error);
        //throw error as per requirement
        return throwError(() => error);
      })
    );
  }
}
