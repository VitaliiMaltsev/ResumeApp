package com.company.web;

import com.company.model.MultiTextSection;
import com.company.model.Section;
import com.company.model.SectionType;
import com.company.model.TextSection;

import java.util.Collections;

import static com.company.web.HtmlUtil.input;
import static com.company.web.HtmlUtil.textArea;

public enum SectionHtmlType {
    TEXT {
        @Override
        public String toHtml(Section section, SectionType type) {
            return input(type.name(), section == null ? "" : ((TextSection) section).getValue());
        }

        @Override
        public TextSection createSection(String value) {
            return new TextSection(value);
        }
    },
    MULTI_TEXT {
        @Override
        public String toHtml(Section section, SectionType type) {
            return textArea(type.name(), section == null ? Collections.singletonList("") : ((MultiTextSection) section).getValues());
        }

        @Override
        public MultiTextSection createSection(String values) {
            return new MultiTextSection(values.split("\\n"));
        }
    },
    ORGANIZATION {
        @Override
        public String toHtml(Section section, SectionType type) {
            String result = "";
            if (section == null) {
                result = " ";
            }
            else result = section.toString();
            return  result;
        }

        @Override
        public Section createSection(String value) {
            throw new UnsupportedOperationException();
        }
    };

    public abstract String toHtml(Section section, SectionType type);

    public abstract Section createSection(String value);
}
