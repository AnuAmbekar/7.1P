package com.example.myapplication;

    public class User {

        private String name, phone, description, date, location, status;
        public User(String name, String phone, String description, String date, String location, String status) {
            this.name = name;
            this.phone = phone;
            this.description = description;
            this.date = date;
            this.location = location;
            this.status = status;
        }


        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhone() {
            return phone;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLocation() {
            return location;
        }
    }


