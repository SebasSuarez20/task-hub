output "db_endpoint" {
  description = "RDS endpoint"
  value = aws_db_instance.taskhub_db_v1_0.endpoint
}

