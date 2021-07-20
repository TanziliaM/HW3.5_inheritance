package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
    @NoArgsConstructor
    @Data
    @EqualsAndHashCode(callSuper = true)

    public class Smartphone extends Product {
        private String maker;

        public Smartphone(int id, String name, int price, String maker) {
            super(id, name, price);
            this.maker = maker;
        }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maker);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "maker='" + maker + '\'' +
                '}';
    }
    }


