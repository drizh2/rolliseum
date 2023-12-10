import {Component} from '@angular/core';
import {Classes} from './entity/enum/classes';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  value = Object.keys(Classes)[Object.values(Classes).indexOf(Classes.ARTIFICER)];
  title = 'client';

}
