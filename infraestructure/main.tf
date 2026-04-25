provider "aws" {
  region = var.region
}

# 🔐 Security Group para MySQL
resource "aws_security_group" "db_sg" {
  name        = "taskhub-db-sg"
  description = "Allow MySQL access"

  ingress {
    description = "MySQL access"
    from_port   = 3306
    to_port     = 3306
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # se puede restrigir si es Prod
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

# 🗄️ RDS MySQL
resource "aws_db_instance" "taskhub_db" {
  identifier = "taskhub-db"

  engine         = "mysql"
  engine_version = "8.0"
  instance_class = "db.t3.micro"

  allocated_storage = 20

  db_name  = var.db_name
  username = var.db_user
  password = var.db_password

  vpc_security_group_ids = [aws_security_group.db_sg.id]

  publicly_accessible = true
  skip_final_snapshot = true

  tags = {
    Name = "TaskHubDB"
  }
}