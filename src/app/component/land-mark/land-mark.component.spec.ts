import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LandMarkComponent } from './land-mark.component';

describe('LandMarkComponent', () => {
  let component: LandMarkComponent;
  let fixture: ComponentFixture<LandMarkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LandMarkComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LandMarkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
