package com.company.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable{
    private Link link;
    private List<Period> periods;

    public Organization(Link link, List<Period> periods) {
        this.link = link;
        this.periods = periods;
    }

    //    public Organization(String organization1, Object o, Period period) {
//    }
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Period implements Serializable {
        static final long serialVersionUID =1L;
        public static final LocalDate NOW =LocalDate.now();
        private LocalDate startDate;
        private LocalDate endDate;
        private String position;
        private String comment;

        public Period() {
        }

        public Period(int startYear, Month startMonth, int endYear, Month endMonth, String position, String content){
            this(LocalDate.of(startYear,startMonth,1),LocalDate.of(endYear,endMonth,1),position,content);
        }

        public Period(LocalDate startDate, LocalDate endDate, String position, String comment) {

            this.startDate = startDate;
            this.endDate = endDate;
            this.position = position;
            this.comment = comment;
        }
    }
}
