package io.milvus.client;

import javax.annotation.*;

// Builder Pattern
public class TableSchema {
    private final String tableName;
    private final long dimension;
    private final long indexFileSize;
    private final MetricType metricType;

    public static class Builder {
        // Required parameters
        private final String tableName;
        private final long dimension;

        // Optional parameters - initialized to default values
        private long indexFileSize = 1024;
        private MetricType metricType = MetricType.L2;

        public Builder(@Nonnull String tableName, long dimension) {
            this.tableName = tableName;
            this.dimension = dimension;
        }

        public Builder withIndexFileSize(long indexFileSize) {
            this.indexFileSize = indexFileSize;
            return this;
        }
        public Builder withMetricType(@Nonnull MetricType metricType) {
            this.metricType = metricType;
            return this;
        }

        public TableSchema build() {
            return new TableSchema(this);
        }
    }

    private TableSchema(@Nonnull Builder builder) {
        tableName = builder.tableName;
        dimension = builder.dimension;
        indexFileSize = builder.indexFileSize;
        metricType = builder.metricType;
    }

    public String getTableName() {
        return tableName;
    }

    public long getDimension() {
        return dimension;
    }

    public long getIndexFileSize() {
        return indexFileSize;
    }

    public MetricType getMetricType() {
        return metricType;
    }

    @Override
    public String toString() {
        return String.format("TableSchema = {tableName = %s, dimension = %d, indexFileSize = %d, metricType = %s}",
                             tableName, dimension, indexFileSize, metricType.name());
    }
}