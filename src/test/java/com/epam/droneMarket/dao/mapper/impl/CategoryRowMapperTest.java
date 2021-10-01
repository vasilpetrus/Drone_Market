package com.epam.droneMarket.dao.mapper.impl;

import com.epam.droneMarket.dao.mapper.Column;
import com.epam.droneMarket.entity.Category;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryRowMapperTest {

    private static final long EXPECTED_LONG = 1L;
    private static final String EXPECTED_STRING = "test";

    @Test
    void testMap_ShouldReturnCategory_WhenDataIsCorrect() throws SQLException {
        ResultSet rsMock = Mockito.mock(ResultSet.class);
        Mockito.when(rsMock.getLong(Column.ID)).thenReturn(EXPECTED_LONG);
        Mockito.when(rsMock.getString(Column.CATEGORY_NAME)).thenReturn(EXPECTED_STRING);

        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
        Category actual = categoryRowMapper.map(rsMock);

        Category expected = new Category();
        expected.setId(EXPECTED_LONG);
        expected.setCategoryName(EXPECTED_STRING);

        assertEquals(expected, actual);
    }
}
