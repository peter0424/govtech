import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EMPTY, Observable, catchError, throwError } from 'rxjs';
import { NzMessageService } from 'ng-zorro-antd/message';


@Injectable()
export class Interceptor implements HttpInterceptor {

  constructor(private messageService: NzMessageService) {

  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(
      catchError((httpError: HttpErrorResponse) => {
        console.log(httpError);
        if (httpError instanceof HttpErrorResponse && httpError.status != 200) {
          this.messageService.error(httpError.error);
        }
        return throwError(() => httpError);
      }));
  }
}
