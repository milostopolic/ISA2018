import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentacarsearchComponent } from './rentacarsearch.component';

describe('RentacarsearchComponent', () => {
  let component: RentacarsearchComponent;
  let fixture: ComponentFixture<RentacarsearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentacarsearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentacarsearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
