package com.example.poemapp.models

import com.example.poemapp.models.Validations.ValidationResult

class FormData (
    private var UserName:String,
    private var password:String,

    ){
    fun validateusername(): ValidationResult {
        return if(UserName.isEmpty()){
            ValidationResult.Empty("Username is empty")
        } else if (UserName.length > 10) {
            ValidationResult.Invalid(" Username should have 10 characters")
        }else{
            ValidationResult.Valid
        }
    }

    fun validatePassword(): ValidationResult {
        return if(password.isEmpty()){
            ValidationResult.Empty("Password is empty")
        }else if(password.length<8){
            ValidationResult.Invalid("password should have 8 characters")
        }else if(password.length>8){
            ValidationResult.Invalid("password should have 10 characters")
        }else{
            ValidationResult.Valid
        }
    }



}