package com.kunal.hashmap;

import java.util.LinkedList;

public class MapLinkedList {

    LinkedList<Entity> entities = new LinkedList<>();

    // Just to understand. This is inefficient ofc.

    public String get(String key) {
        for (Entity entity : entities) {
            if (entity.key.equals(key)) {
                return entity.value;
            }
        }
        return null;
    }

    public void put(String key, String value) {

        for (Entity entity : entities) {
            if (entity.key.equals(key)) {
                entity.value = value;
                return;
            }
        }
        entities.add(new Entity(key, value));
    }

    public void remove(String key) {

        Entity target = null;

        // because you cannot remove while traversing like this
        for (Entity entity : entities) {
            if (entity.key.equals(key)) {
                target = entity;
                break;
            }
        }
        entities.remove(target);
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("{");
        for (Entity entity : entities) {
            s.append(entity.key).append(" = ").append(entity.value);
        }
        s.append("}");
        return s.toString();
    }

    private static class Entity {

        private String key;
        private String value;

        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
