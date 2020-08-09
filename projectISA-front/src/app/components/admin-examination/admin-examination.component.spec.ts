import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminExaminationComponent } from './admin-examination.component';

describe('AdminExaminationComponent', () => {
  let component: AdminExaminationComponent;
  let fixture: ComponentFixture<AdminExaminationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminExaminationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminExaminationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
