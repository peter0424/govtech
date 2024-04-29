import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { HomeService } from './home.service';
import { Subject, switchMap, tap } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  restaurantForm: FormGroup;
  restaurantList: Restaurant[] = [];
  result: string = '';
  restaurantList$: Subject<void> = new Subject<void>();
  random$: Subject<void> = new Subject<void>();
  loading = false;

  constructor(private service: HomeService,
    private formBuilder: FormBuilder,
    private messageService: NzMessageService) {
    this.restaurantForm = this.formBuilder.group({
      restaurantName: ['', [Validators.required]]
    });
    this.restaurantList$.pipe(switchMap(() => this.service.listRestaurant()))
      .subscribe((result) => {
        console.log('restaurant list:', result);
        this.restaurantList = result;
      });

    this.random$.pipe(tap(() => this.loading = true), switchMap(() => this.service.getRandomRestaurant()))
      .subscribe((result) => {
        console.log("random restaurant: ", result);
        this.loading = false;
        this.result = result;
      });
  }

  ngOnInit(): void {
    this.restaurantList$.next();
  }

  listRestaurant() {
    this.restaurantList$.next();
  }

  getRandomRestaurant() {
    this.random$.next();
  }

  submit() {
    if (this.validateForm(this.restaurantForm)) {
      const restaurantName = this.restaurantForm.get('restaurantName')?.value;
      this.service.addRestaurant(restaurantName).subscribe(() => {
        this.restaurantList$.next();
        this.messageService.success(`Restaurant "${restaurantName}" added`);
      });
    }
  }

  private validateForm(form: FormGroup): boolean {
    let valid: boolean = true;
    Object.values(form.controls).forEach(control => {
      if (control.invalid) {
        valid = false;
        control.markAsDirty();
        control.updateValueAndValidity({ onlySelf: true });
      }
    });
    return valid;
  }
}

export interface Restaurant {
  id: number;
  name: string;
}
