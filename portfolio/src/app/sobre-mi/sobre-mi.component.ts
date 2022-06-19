import { Component, OnInit } from '@angular/core';
import { SobreMi } from '../classes/SobreMi';
import { SobreMiService } from '../service/sobre-mi.service';

@Component({
  selector: 'app-sobre-mi',
  templateUrl: './sobre-mi.component.html',
  styleUrls: ['./sobre-mi.component.css']
})
export class SobreMiComponent implements OnInit {

  SobreMi: SobreMi = new SobreMi("");

  constructor(public SobreMiService :SobreMiService) {}

  ngOnInit(): void {
    this.SobreMiService.getSobreMi().subscribe(SobreMi => {this.SobreMi = SobreMi})
  }

}
