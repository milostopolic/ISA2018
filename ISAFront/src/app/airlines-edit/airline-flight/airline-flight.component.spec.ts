import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AirlineFlightComponent } from './airline-flight.component';

describe('AirlineFlightComponent', () => {
  let component: AirlineFlightComponent;
  let fixture: ComponentFixture<AirlineFlightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AirlineFlightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AirlineFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
