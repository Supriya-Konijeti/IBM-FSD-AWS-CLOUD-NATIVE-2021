package com.example.demo.model;

public class Country {
        String id;
        String countryName;
        long population;
        public Country() {
            super();
        }
        public Country(String id, String countryName,long population) {
            super();
            this.id = id;
            this.countryName = countryName;
            this.population=population;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getCountryName() {
            return countryName;
        }
        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }
        public long getPopulation() {
            return population;
        }
        public void setPopulation(long population) {
            this.population = population;
        }
}
