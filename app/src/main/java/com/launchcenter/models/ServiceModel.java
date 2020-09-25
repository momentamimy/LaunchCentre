package com.launchcenter.models;

public class ServiceModel {
        private int id;
        private String name;
        private String logo;
        private int parent;
        private String description;
        private String dateTime;
        private String serviceCompanies;
        private String bookServiceCompanies;

        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getLogo() {
                return logo;
        }

        public int getParent() {
                return parent;
        }

        public String getDescription() {
                return description;
        }

        public String getDateTime() {
                return dateTime;
        }

        public String getServiceCompanies() {
                return serviceCompanies;
        }

        public String getBookServiceCompanies() {
                return bookServiceCompanies;
        }
}
