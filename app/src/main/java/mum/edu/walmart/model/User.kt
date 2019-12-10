package mum.edu.walmart.model

import java.io.Serializable

class User (firstName:String,lastName:String,userName: String,password:String) : Serializable{
    var firstName:String =  firstName
    var lastName:String = lastName
    var userName:String = userName
    var password:String = password
}