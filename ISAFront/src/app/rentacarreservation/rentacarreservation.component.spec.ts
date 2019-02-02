import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentacarreservationComponent } from './rentacarreservation.component';

describe('RentacarreservationComponent', () => {
  let component: RentacarreservationComponent;
  let fixture: ComponentFixture<RentacarreservationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentacarreservationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentacarreservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
