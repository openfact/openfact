/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { LimitedStringComponent } from './limited-string.component';

describe('LimitedStringComponent', () => {
  let component: LimitedStringComponent;
  let fixture: ComponentFixture<LimitedStringComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LimitedStringComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LimitedStringComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
