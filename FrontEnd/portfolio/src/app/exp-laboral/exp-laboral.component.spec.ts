import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpLaboralComponent } from './exp-laboral.component';

describe('ExpLaboralComponent', () => {
  let component: ExpLaboralComponent;
  let fixture: ComponentFixture<ExpLaboralComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExpLaboralComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpLaboralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
