import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FriendshipComponent } from './friendship.component';

describe('FriendshipComponent', () => {
  let component: FriendshipComponent;
  let fixture: ComponentFixture<FriendshipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FriendshipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FriendshipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
