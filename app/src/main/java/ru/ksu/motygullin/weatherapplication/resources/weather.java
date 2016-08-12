package ru.ksu.motygullin.weatherapplication.resources;

import org.json.JSONObject;

/**
 * Created by UseR7 on 04.07.2016.
 */
public class weather {

    public location location;
    public CurrentCondition currentCondition = new CurrentCondition();
    public byte[] iconData;

    public class CurrentCondition {
        private int id;
        private String main;
        private String description;
        private double temp;
        private String icon;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }



        public String getIcon() {
            return icon;
        }
        public void setIcon(String icon) {
            this.icon = icon;
        }

    }



}
