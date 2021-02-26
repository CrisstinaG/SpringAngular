import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  user: User;
  formSubmitted = false;

  fn = 'firstName';
  ln = 'lastName';
  e = 'email';

  namePattern = '[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+';
  emailPattern = '[a-z0-9._%+-]+@[a-z0-9.-]+[.]{1}[a-z]{2,3}';

  testForm = this.fb.group({
    firstName: ['', [Validators.required, Validators.pattern(this.namePattern)]],
    lastName: ['', [Validators.required, Validators.pattern(this.namePattern)]],
    email: ['', [Validators.required, Validators.pattern(this.emailPattern)]],
  });

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.user = new User('', '', '');

  }

  submitForm(form: any): void {
       console.log('Form Data: ');
       console.log(form);
       // user.firstName = form.firstName
   }

  isFieldValid(field: string): any {
    return (
      this.testForm.get(field).errors && this.testForm.get(field).touched ||
      this.testForm.get(field).untouched &&
      this.formSubmitted && this.testForm.get(field).errors
    );
  }

  onSubmit(): void {
    this.formSubmitted = true;
    if (this.testForm.valid) {
      alert('VALID');
    } else {
      alert('NOT VALID');
    }
  }

}
