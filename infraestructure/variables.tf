variable "region" {
  description = "AWS region"
  default     = "us-east-2"
}

variable "db_name" {
  description = "Database name"
  default     = "taskHubDb"
  
}

variable "db_user" {
  description = "Database username"
  default     = "root"
}

variable "db_password" {
  description = "Database password"
  default     = "admin12345!.<"
}