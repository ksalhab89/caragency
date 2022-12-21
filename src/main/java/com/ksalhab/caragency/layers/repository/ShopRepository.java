package com.ksalhab.caragency.layers.repository;

import com.ksalhab.caragency.layers.domain.Shop;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class ShopRepository {

	private final JdbcTemplate jdbcTemplate;
	private RowMapper<Shop> rowMapper;

	@SneakyThrows(value = EmptyResultDataAccessException.class)
	public Shop getShop(Long id) {
		return jdbcTemplate.queryForObject("select * public.carshop " +
				                                   "where id=?", rowMapper, id);
	}

	public List<Shop> getAllShops() {
		return jdbcTemplate.query("select * from carshop", rowMapper);
	}

	public Shop addShop(Shop shop) {
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(con -> {
			PreparedStatement preparedStatement = con.prepareStatement(
					"INSERT INTO public.carshop(\n" +
							"\tlocation, inventory, currently_open, number_of_employees, open_since)\n" +
							"\tVALUES (?, ?, ?, ?, ?)", new String[]{"id"});

			shopStatementParsing(shop, preparedStatement);
			return preparedStatement;
		}, keyHolder);

		long generatedKey = Objects.requireNonNull(keyHolder.getKey()).longValue();
		return getShop(generatedKey);
	}

	public Shop updateShop(Long id, Shop shop) {
		jdbcTemplate.update(con -> {
			PreparedStatement preparedStatement = con.prepareStatement(
					"UPDATE public.carshop\n" +
							"\tSET location=?, inventory=?, currently_open=?, number_of_employees=?, open_since=?\n" +
							"\tWHERE id=?");

			shopStatementParsing(shop, preparedStatement);
			preparedStatement.setLong(6, id);

			return preparedStatement;
		});
		return getShop(id);
	}

	public void deleteShop(Long id) {
		jdbcTemplate.update("DELETE FROM public.carshop WHERE id=?", id);
	}

	private static void shopStatementParsing(Shop shop, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, shop.getLocation());
		preparedStatement.setInt(2, shop.getInventory());
		preparedStatement.setBoolean(3, shop.getCurrentlyOpen());
		preparedStatement.setInt(4, shop.getNumberOfEmployees());
		preparedStatement.setTime(5, (Time) Time.from(shop.getOpenSince()));
	}

}
