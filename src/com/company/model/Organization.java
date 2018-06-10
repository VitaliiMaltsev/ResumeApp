package com.company.model;

import java.util.Date;
import java.util.List;

public class Organization {
    private Link link;
    private List<Period> periods;

    public static class Period {
        private Date startDate;
        private Date endDate;
        private String position;
        private String comment;

        public Period() {
        }

        public Period(Date startDate, Date endDate, String position, String comment) {

            this.startDate = startDate;
            this.endDate = endDate;
            this.position = position;
            this.comment = comment;
        }
    }
}
