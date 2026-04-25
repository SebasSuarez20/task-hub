variable "region" {
  description = "AWS region"
  default     = "us-east-2"
}

variable "db_name" {
  description = "Database name"
  default     = "db_information_franchise_v1_0"

}

variable "db_user" {
  description = "Database username"
  default     = "admin"
}

variable "db_password" {
  description = "Database password"
  default     = "admin12345!"
}