import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HomeService } from './home.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  restaurantForm: FormGroup;
  restaurantList: Restaurant[] = [];
  draw: string = '';

  constructor(private service: HomeService, private formBuilder: FormBuilder) {
    this.restaurantForm = this.formBuilder.group({
      restaurantName: ['', [Validators.required, Validators.minLength(3)]]
    });
  }

  ngOnInit(): void {
    this.service.listRestaurant().subscribe((result) => {
      console.log('restaurant list:', result);
      this.restaurantList = result;
    });
  }

  listRestaurant() {
    this.service.listRestaurant().subscribe((result) => {
      console.log('restaurant list:', result);
    });
  }

  getRandomRestaurant() {
    this.service.getRandomRestaurant().subscribe((result) => {
      console.log("random restaurant: ", result);
      this.draw = result;
    });
  }

  submit() {
    if (this.restaurantForm.valid) {
      const restaurantName = this.restaurantForm.get('restaurantName')?.value;
      this.service.addRestaurant(restaurantName).subscribe(() => {
        console.log('restaurant name:', restaurantName);
      });
    } else {
      console.log('Form validation failed.');
    }
  }

}

export interface Restaurant {
  id: number;
  name: string;
}
