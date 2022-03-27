package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import coding.mentor.constant.Constant;
import coding.mentor.db.DBUtil;
import coding.mentor.dto.ProductDTO;
import coding.mentor.entity.ProductDetail;
import coding.mentor.util.DataUtil;

public class ProductDetailDAO {
		DataUtil dataUtil = new DataUtil();

		public int getFilterAllProduct(String brand, String price, String condition) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select count(*) from product";
			String extraCondition = null;

			try {
				conn = DBUtil.makeConnection();
				if ((brand == null && price == null && condition == null)
						|| (brand.equals("default") && price.equals("default") && condition.equals("default"))) {
					ps = conn.prepareStatement(sql);
				} else if (!brand.equals("default") && price.equals("default") && condition.equals("default")) {
					extraCondition = " where brand like ?";
					sql += extraCondition;
					ps = conn.prepareStatement(sql);
					ps.setString(1, "%" + brand + "%");
				} else if (!price.equals("default") && brand.equals("default") && condition.equals("default")) {
					extraCondition = " where price > ? and price < ?";
					sql += extraCondition;
					String[] editPrice = price.split("/");
					ps = conn.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(editPrice[0]));
					ps.setInt(2, Integer.parseInt(editPrice[1]));
				} else if (!condition.equals("default") && price.equals("default") && brand.equals("default")) {
					if (condition.equals("price in descending order")) {
						extraCondition = " order by price desc";
					} else if (condition.equals("price in ascending order")) {
						extraCondition = " order by price asc";
					} else if (condition.equals("name from A to Z")) {
						extraCondition = " order by name";
					} else if (condition.equals("name from Z to A")) {
						extraCondition = " order by name desc";
					}
					sql += extraCondition;
					ps = conn.prepareStatement(sql);
				} else if (!brand.equals("default") && !price.equals("default") && condition.equals("default")) {
					extraCondition = " where brand like ? and price > ? and price < ?";
					sql += extraCondition;
					ps = conn.prepareStatement(sql);
					ps.setString(1, "%" + brand + "%");
					String[] editPrice = price.split("/");
					ps.setInt(2, Integer.parseInt(editPrice[0]));
					ps.setInt(3, Integer.parseInt(editPrice[1]));
				} else if (!brand.equals("default") && price.equals("default") && !condition.equals("default")) {
					extraCondition = " where brand like ?";
					if (condition.equals("price in descending order")) {
						extraCondition += " order by price desc";
					} else if (condition.equals("price in ascending order")) {
						extraCondition += " order by price asc";
					} else if (condition.equals("name from A to Z")) {
						extraCondition += " order by name";
					} else if (condition.equals("name from Z to A")) {
						extraCondition += " order by name desc";
					}
					sql += extraCondition;
					ps = conn.prepareStatement(sql);
					ps.setString(1, "%" + brand + "%");
				} else if (brand.equals("default") && !price.equals("default") && !condition.equals("default")) {
					extraCondition = " where price > ? and price < ?";
					String[] editPrice = price.split("/");
					if (condition.equals("price in descending order")) {
						extraCondition += " order by price desc";
					} else if (condition.equals("price in ascending order")) {
						extraCondition += " order by price asc";
					} else if (condition.equals("name from A to Z")) {
						extraCondition += " order by name";
					} else if (condition.equals("name from Z to A")) {
						extraCondition += " order by name desc";
					}
					sql += extraCondition;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(editPrice[0]));
					ps.setInt(2, Integer.parseInt(editPrice[1]));
				} else {
					extraCondition = " where brand like ? and price > ? and price < ?";
					String[] editPrice = price.split("/");
					if (condition.equals("price in descending order")) {
						extraCondition += " order by price desc";
					} else if (condition.equals("price in ascending order")) {
						extraCondition += " order by price asc";
					} else if (condition.equals("name from A to Z")) {
						extraCondition += " order by name";
					} else if (condition.equals("name from Z to A")) {
						extraCondition += " order by name desc";
					}
					sql += extraCondition;
					ps = conn.prepareStatement(sql);
					ps.setString(1, "%" + brand + "%");
					ps.setInt(2, Integer.parseInt(editPrice[0]));
					ps.setInt(3, Integer.parseInt(editPrice[1]));
				}
				rs = ps.executeQuery();

				while (rs.next()) {
					return rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, ps, rs);
			}
			return 0;
		}

		public List<ProductDetail> filterAllProduct(String brand, String price, String condition, String view, int index) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ProductDetail product = null;
			List<ProductDetail> products = new ArrayList<ProductDetail>();
			String sql = "select * from product limit ? offset ?";
			String extraCondition = null;
			int limitIndex = sql.indexOf("limit");
			String firstPart = sql.substring(0, limitIndex);
			String lastPart = sql.substring(limitIndex);

			try {
				conn = DBUtil.makeConnection();
				if ((brand == null && price == null && condition == null)
						|| (brand.equals("default") && price.equals("default") && condition.equals("default"))) {
					ps = conn.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(view));
					ps.setInt(2, (index - 1) * Integer.parseInt(view));
				} else if (!brand.equals("default") && price.equals("default") && condition.equals("default")) {
					extraCondition = " where brand like ? ";
					sql = firstPart + extraCondition + lastPart;
					ps = conn.prepareStatement(sql);
					ps.setString(1, "%" + brand + "%");
					ps.setInt(2, Integer.parseInt(view));
					ps.setInt(3, (index - 1) * Integer.parseInt(view));
				} else if (!price.equals("default") && brand.equals("default") && condition.equals("default")) {
					extraCondition = " where price > ? and price < ? ";
					sql = firstPart + extraCondition + lastPart;
					String[] editPrice = price.split("/");
					ps = conn.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(editPrice[0]));
					ps.setInt(2, Integer.parseInt(editPrice[1]));
					ps.setInt(3, Integer.parseInt(view));
					ps.setInt(4, (index - 1) * Integer.parseInt(view));
				} else if (!condition.equals("default") && price.equals("default") && brand.equals("default")) {
					if (condition.equals("price in descending order")) {
						extraCondition = " order by price desc ";
					} else if (condition.equals("price in ascending order")) {
						extraCondition = " order by price asc ";
					} else if (condition.equals("name from A to Z")) {
						extraCondition = " order by name ";
					} else if (condition.equals("name from Z to A")) {
						extraCondition = " order by name desc ";
					}
					sql = firstPart + extraCondition + lastPart;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(view));
					ps.setInt(2, (index - 1) * Integer.parseInt(view));
				} else if (!brand.equals("default") && !price.equals("default") && condition.equals("default")) {
					extraCondition = " where brand like ? and price > ? and price < ? ";
					sql = firstPart + extraCondition + lastPart;
					ps = conn.prepareStatement(sql);
					ps.setString(1, "%" + brand + "%");
					String[] editPrice = price.split("/");
					ps.setInt(2, Integer.parseInt(editPrice[0]));
					ps.setInt(3, Integer.parseInt(editPrice[1]));
					ps.setInt(4, Integer.parseInt(view));
					ps.setInt(5, (index - 1) * Integer.parseInt(view));
				} else if (!brand.equals("default") && price.equals("default") && !condition.equals("default")) {
					extraCondition = " where brand like ?";
					if (condition.equals("price in descending order")) {
						extraCondition += " order by price desc ";
					} else if (condition.equals("price in ascending order")) {
						extraCondition += " order by price asc ";
					} else if (condition.equals("name from A to Z")) {
						extraCondition += " order by name ";
					} else if (condition.equals("name from Z to A")) {
						extraCondition += " order by name desc ";
					}
					sql = firstPart + extraCondition + lastPart;
					ps = conn.prepareStatement(sql);
					ps.setString(1, "%" + brand + "%");
					ps.setInt(2, Integer.parseInt(view));
					ps.setInt(3, (index - 1) * Integer.parseInt(view));
				} else if (brand.equals("default") && !price.equals("default") && !condition.equals("default")) {
					extraCondition = " where price > ? and price < ?";
					String[] editPrice = price.split("/");
					if (condition.equals("price in descending order")) {
						extraCondition += " order by price desc ";
					} else if (condition.equals("price in ascending order")) {
						extraCondition += " order by price asc ";
					} else if (condition.equals("name from A to Z")) {
						extraCondition += " order by name ";
					} else if (condition.equals("name from Z to A")) {
						extraCondition += " order by name desc ";
					}
					sql = firstPart + extraCondition + lastPart;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(editPrice[0]));
					ps.setInt(2, Integer.parseInt(editPrice[1]));
					ps.setInt(3, Integer.parseInt(view));
					ps.setInt(4, (index - 1) * Integer.parseInt(view));
				} else {
					extraCondition = " where brand like ? and price > ? and price < ?";
					String[] editPrice = price.split("/");
					if (condition.equals("price in descending order")) {
						extraCondition += " order by price desc ";
					} else if (condition.equals("price in ascending order")) {
						extraCondition += " order by price asc ";
					} else if (condition.equals("name from A to Z")) {
						extraCondition += " order by name ";
					} else if (condition.equals("name from Z to A")) {
						extraCondition += " order by name desc ";
					}
					sql = firstPart + extraCondition + lastPart;
					ps = conn.prepareStatement(sql);
					ps.setString(1, "%" + brand + "%");
					ps.setInt(2, Integer.parseInt(editPrice[0]));
					ps.setInt(3, Integer.parseInt(editPrice[1]));
					ps.setInt(4, Integer.parseInt(view));
					ps.setInt(5, (index - 1) * Integer.parseInt(view));
				}
				rs = ps.executeQuery();

				while (rs.next()) {
					product = new ProductDetail();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setSize(rs.getString("size"));
					product.setColor(rs.getString("color"));
					product.setCountry(rs.getString("production_country"));
					product.setMaterial(rs.getString("materials"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getString("price"));
					product.setImageCode(rs.getString("image"));
					product.setCategoryId(rs.getInt("category_id"));
					product.setBrand(rs.getString("brand"));
					products.add(product);
				}
				return products;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, ps, rs);
			}
			return null;
		}

		public List<ProductDetail> filterCategoryProduct(int categoryId, String brand, String price, String condition,
				String view, int index) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ProductDetail product = null;
			List<ProductDetail> products = new ArrayList<ProductDetail>();
			String sql = "select * from product where category_id = ? limit ? offset ?";
			String extraCondition = null;
			int limitIndex = sql.indexOf("limit");
			String firstPart = sql.substring(0, limitIndex);
			String lastPart = sql.substring(limitIndex);

			try {
				conn = DBUtil.makeConnection();
				if ((brand == null && price == null && condition == null)
						|| (brand.equals("default") && price.equals("default") && condition.equals("default"))) {
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setInt(2, Integer.parseInt(view));
					ps.setInt(3, (index - 1) * Integer.parseInt(view));
				} else if (!brand.equals("default") && price.equals("default") && condition.equals("default")) {
					extraCondition = " and brand like ? ";
					sql = firstPart + extraCondition + lastPart;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setString(2, "%" + brand + "%");
					ps.setInt(3, Integer.parseInt(view));
					ps.setInt(4, (index - 1) * Integer.parseInt(view));
				} else if (!price.equals("default") && brand.equals("default") && condition.equals("default")) {
					extraCondition = " and price > ? and price < ? ";
					sql = firstPart + extraCondition + lastPart;
					String[] editPrice = price.split("/");
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setInt(2, Integer.parseInt(editPrice[0]));
					ps.setInt(3, Integer.parseInt(editPrice[1]));
					ps.setInt(4, Integer.parseInt(view));
					ps.setInt(5, (index - 1) * Integer.parseInt(view));
				} else if (!condition.equals("default") && price.equals("default") && brand.equals("default")) {
					if (condition.equals("price in descending order")) {
						extraCondition = " order by price desc ";
					} else if (condition.equals("price in ascending order")) {
						extraCondition = " order by price asc ";
					} else if (condition.equals("name from A to Z")) {
						extraCondition = " order by name ";
					} else if (condition.equals("name from Z to A")) {
						extraCondition = " order by name desc ";
					}
					sql = firstPart + extraCondition + lastPart;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setInt(2, Integer.parseInt(view));
					ps.setInt(3, (index - 1) * Integer.parseInt(view));
				} else if (!brand.equals("default") && !price.equals("default") && condition.equals("default")) {
					extraCondition = " and brand like ? and price > ? and price < ? ";
					sql = firstPart + extraCondition + lastPart;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setString(2, "%" + brand + "%");
					String[] editPrice = price.split("/");
					ps.setInt(3, Integer.parseInt(editPrice[0]));
					ps.setInt(4, Integer.parseInt(editPrice[1]));
					ps.setInt(5, Integer.parseInt(view));
					ps.setInt(6, (index - 1) * Integer.parseInt(view));
				} else if (!brand.equals("default") && price.equals("default") && !condition.equals("default")) {
					extraCondition = " and brand like ?";
					if (condition.equals("price in descending order")) {
						extraCondition += " order by price desc ";
					} else if (condition.equals("price in ascending order")) {
						extraCondition += " order by price asc ";
					} else if (condition.equals("name from A to Z")) {
						extraCondition += " order by name ";
					} else if (condition.equals("name from Z to A")) {
						extraCondition += " order by name desc ";
					}
					sql = firstPart + extraCondition + lastPart;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setString(2, "%" + brand + "%");
					ps.setInt(3, Integer.parseInt(view));
					ps.setInt(4, (index - 1) * Integer.parseInt(view));
				} else if (brand.equals("default") && !price.equals("default") && !condition.equals("default")) {
					extraCondition = " and price > ? and price < ?";
					String[] editPrice = price.split("/");
					if (condition.equals("price in descending order")) {
						extraCondition += " order by price desc ";
					} else if (condition.equals("price in ascending order")) {
						extraCondition += " order by price asc ";
					} else if (condition.equals("name from A to Z")) {
						extraCondition += " order by name ";
					} else if (condition.equals("name from Z to A")) {
						extraCondition += " order by name desc ";
					}
					sql = firstPart + extraCondition + lastPart;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setInt(2, Integer.parseInt(editPrice[0]));
					ps.setInt(3, Integer.parseInt(editPrice[1]));
					ps.setInt(4, Integer.parseInt(view));
					ps.setInt(5, (index - 1) * Integer.parseInt(view));
				} else {
					extraCondition = " and brand like ? and price > ? and price < ?";
					String[] editPrice = price.split("/");
					if (condition.equals("price in descending order")) {
						extraCondition += " order by price desc ";
					} else if (condition.equals("price in ascending order")) {
						extraCondition += " order by price asc ";
					} else if (condition.equals("name from A to Z")) {
						extraCondition += " order by name ";
					} else if (condition.equals("name from Z to A")) {
						extraCondition += " order by name desc ";
					}
					sql = firstPart + extraCondition + lastPart;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setString(2, "%" + brand + "%");
					ps.setInt(3, Integer.parseInt(editPrice[0]));
					ps.setInt(4, Integer.parseInt(editPrice[1]));
					ps.setInt(5, Integer.parseInt(view));
					ps.setInt(6, (index - 1) * Integer.parseInt(view));
				}
				System.out.println(sql);
				System.out.println("");
				System.out.println(ps);
				System.out.println("");
				rs = ps.executeQuery();
				System.out.println(rs);

				while (rs.next()) {
					product = new ProductDetail();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setSize(rs.getString("size"));
					product.setColor(rs.getString("color"));
					product.setCountry(rs.getString("production_country"));
					product.setMaterial(rs.getString("materials"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getString("price"));
					product.setImageCode(rs.getString("image"));
					product.setCategoryId(rs.getInt("category_id"));
					product.setBrand(rs.getString("brand"));
					products.add(product);
				}
				return products;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, ps, rs);
			}
			return null;
		}

		public int getFilterCategoryProduct(int categoryId, String brand, String price, String condition) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select count(*) from product where category_id = ?";
			String extraCondition = null;

			try {
				conn = DBUtil.makeConnection();
				if ((brand == null && price == null && condition == null)
						|| (brand.equals("default") && price.equals("default") && condition.equals("default"))) {
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
				} else if (!brand.equals("default") && price.equals("default") && condition.equals("default")) {
					extraCondition = " and brand like ? ";
					sql += extraCondition;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setString(2, "%" + brand + "%");
				} else if (!price.equals("default") && brand.equals("default") && condition.equals("default")) {
					extraCondition = " and price > ? and price < ? ";
					sql += extraCondition;
					String[] editPrice = price.split("/");
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setInt(2, Integer.parseInt(editPrice[0]));
					ps.setInt(3, Integer.parseInt(editPrice[1]));
				} else if (!condition.equals("default") && price.equals("default") && brand.equals("default")) {
					if (condition.equals("price in descending order")) {
						extraCondition = " order by price desc ";
					} else if (condition.equals("price in ascending order")) {
						extraCondition = " order by price asc ";
					} else if (condition.equals("name from A to Z")) {
						extraCondition = " order by name ";
					} else if (condition.equals("name from Z to A")) {
						extraCondition = " order by name desc ";
					}
					sql += extraCondition;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
				} else if (!brand.equals("default") && !price.equals("default") && condition.equals("default")) {
					extraCondition = " and brand like ? and price > ? and price < ? ";
					sql += extraCondition;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setString(2, "%" + brand + "%");
					String[] editPrice = price.split("/");
					ps.setInt(3, Integer.parseInt(editPrice[0]));
					ps.setInt(4, Integer.parseInt(editPrice[1]));
				} else if (!brand.equals("default") && price.equals("default") && !condition.equals("default")) {
					extraCondition = " and brand like ?";
					if (condition.equals("price in descending order")) {
						extraCondition += " order by price desc ";
					} else if (condition.equals("price in ascending order")) {
						extraCondition += " order by price asc ";
					} else if (condition.equals("name from A to Z")) {
						extraCondition += " order by name ";
					} else if (condition.equals("name from Z to A")) {
						extraCondition += " order by name desc ";
					}
					sql += extraCondition;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setString(2, "%" + brand + "%");
				} else if (brand.equals("default") && !price.equals("default") && !condition.equals("default")) {
					extraCondition = " and price > ? and price < ?";
					String[] editPrice = price.split("/");
					if (condition.equals("price in descending order")) {
						extraCondition += " order by price desc ";
					} else if (condition.equals("price in ascending order")) {
						extraCondition += " order by price asc ";
					} else if (condition.equals("name from A to Z")) {
						extraCondition += " order by name ";
					} else if (condition.equals("name from Z to A")) {
						extraCondition += " order by name desc ";
					}
					sql += extraCondition;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setInt(2, Integer.parseInt(editPrice[0]));
					ps.setInt(3, Integer.parseInt(editPrice[1]));
				} else {
					extraCondition = " and brand like ? and price > ? and price < ?";
					String[] editPrice = price.split("/");
					if (condition.equals("price in descending order")) {
						extraCondition += " order by price desc ";
					} else if (condition.equals("price in ascending order")) {
						extraCondition += " order by price asc ";
					} else if (condition.equals("name from A to Z")) {
						extraCondition += " order by name ";
					} else if (condition.equals("name from Z to A")) {
						extraCondition += " order by name desc ";
					}
					sql += extraCondition;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, categoryId);
					ps.setString(2, "%" + brand + "%");
					ps.setInt(3, Integer.parseInt(editPrice[0]));
					ps.setInt(4, Integer.parseInt(editPrice[1]));
				}
				rs = ps.executeQuery();

				while (rs.next()) {
					return rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, ps, rs);
			}
			return 0;
		}

		public List<ProductDetail> getNewArrival() throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ProductDetail product = null;
			List<ProductDetail> products = new ArrayList<ProductDetail>();

			try {
				conn = DBUtil.makeConnection();
				String sql = "select * from product order by id desc limit 5;";

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					product = new ProductDetail();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setSize(rs.getString("size"));
					product.setColor(rs.getString("color"));
					product.setCountry(rs.getString("production_country"));
					product.setMaterial(rs.getString("materials"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getString("price"));
					product.setImageCode(rs.getString("image"));
					product.setCategoryId(rs.getInt("category_id"));
					product.setBrand(rs.getString("brand"));
					products.add(product);
				}
				return products;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, ps, rs);
			}
			return null;
		}

		public List<ProductDetail> pagingProductBySearch(int index, String search) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ProductDetail product = null;
			List<ProductDetail> products = new ArrayList<ProductDetail>();

			try {
				conn = DBUtil.makeConnection();
				String sql = "select * from product where match(name) against(?) limit 6 offset ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "'" + dataUtil.convertTextSearch(search) + "'");
				ps.setInt(2, (index - 1) * Constant.NUMBER_OF_PRODUCT_PER_PAGE);
				rs = ps.executeQuery();

				while (rs.next()) {
					product = new ProductDetail();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setSize(rs.getString("size"));
					product.setColor(rs.getString("color"));
					product.setCountry(rs.getString("production_country"));
					product.setMaterial(rs.getString("materials"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getString("price"));
					product.setImageCode(rs.getString("image"));
					product.setCategoryId(rs.getInt("category_id"));
					product.setBrand(rs.getString("brand"));
					products.add(product);
				}
				return products;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, ps, rs);
			}
			return null;
		}

		public int getTotalProductBySearchName(String search) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				conn = DBUtil.makeConnection();
				String sql = "select count(*) from product where match(name) against(?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "'" + dataUtil.convertTextSearch(search) + "'");
				rs = ps.executeQuery();
				while (rs.next()) {
					return rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, ps, rs);
			}
			return 0;
		}

		public ArrayList<String> getAllBrand() {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<String> brand = new ArrayList<String>();

			try {
				conn = DBUtil.makeConnection();
				String sql = "select distinct(brand) from product";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while (rs.next()) {
					brand.add(rs.getString("brand"));
				}
				return brand;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, ps, rs);
			}
			return null;
		}

		public ArrayList<String> getBrandByCategory(int categoryId) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<String> brand = new ArrayList<String>();

			try {
				conn = DBUtil.makeConnection();
				String sql = "select distinct(brand) from product where category_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, categoryId);
				rs = ps.executeQuery();

				while (rs.next()) {
					brand.add(rs.getString("brand"));
				}
				return brand;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, ps, rs);
			}
			return null;
		}
		
		public ProductDetail getProductDetailById (long productId) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ProductDetail product = null;
			
			try {
				conn = DBUtil.makeConnection();
				String sql = "select * from product where id = ?";
				ps = conn.prepareStatement(sql);
				ps.setLong(1, productId);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					product = new ProductDetail();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setSize(rs.getString("size"));
					product.setColor(rs.getString("color"));
					product.setCountry(rs.getString("production_country"));
					product.setMaterial(rs.getString("materials"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getString("price"));
					product.setImageCode(rs.getString("image"));
					product.setCategoryId(rs.getInt("category_id"));
					product.setBrand(rs.getString("brand"));
				}
				return product;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		public List<ProductDetail> getAllProduct() throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ProductDetail product = null;
			List<ProductDetail> products = new ArrayList<ProductDetail>();
			
			try {
				conn = DBUtil.makeConnection();
				String sql = "SELECT * FROM product";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					product = new ProductDetail();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setSize(rs.getString("size"));
					product.setColor(rs.getString("color"));
					product.setCountry(rs.getString("production_country"));
					product.setMaterial(rs.getString("materials"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getString("price"));
					product.setImageCode(rs.getString("image"));
					product.setCategoryId(rs.getLong("category_id"));
					product.setBrand(rs.getString("brand"));
					System.out.println(rs.getLong("category_id") + "/n");
					products.add(product);			
				} 
				return products;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, ps, rs);
			}		
			return null;
		}
		
		public void insertProduct(String name, String size, String color, String production_country, String materials, String description, String price, String category_id, String brand) {
			Connection conn = null;
			PreparedStatement ps = null;

			try {
				// make connection to Mysql
				conn = DBUtil.makeConnection();
				String sql = "insert into product (name, size, color, production_country, materials, description, price, category_id, brand) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

				// ps -> contain SQL + parameter values
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, size);
				ps.setString(3, color);
				ps.setString(4, production_country);
				ps.setString(5, materials);
				ps.setString(6, description);
				ps.setFloat(7, Float.parseFloat(price));
				ps.setInt(8, Integer.parseInt(category_id));
				ps.setString(9, brand);
				ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeRegister(conn, ps);
			}
		}
		
			public void updateProduct (ProductDetail product) throws SQLException {
				Connection conn = null;
				PreparedStatement ps = null;
				try {
					conn = DBUtil.makeConnection();
					String sql = "update product set name = ?, size = ?, color = ?, production_country = ?, materials = ?, description = ?, price = ?, category_id = ?, brand = ? where id = ?";
					ps = conn.prepareStatement(sql);
					ps.setString(1, product.getName());
					ps.setString(2, product.getSize());
					ps.setString(3, product.getColor());
					ps.setString(4, product.getCountry());
					ps.setString(5, product.getMaterial());
					ps.setString(6, product.getDescription());
					ps.setFloat(7, Float.parseFloat(product.getPrice()));
					ps.setLong(8, product.getCategoryId());
					ps.setString(9, product.getBrand());
					ps.setLong(10, product.getId());
					
					ps.executeUpdate();
				} finally {
					DBUtil.closeRegister(conn, ps);
				}
			}
			
			public void deleteProduct (int id) throws SQLException {
				Connection conn = null;
				PreparedStatement ps = null;
				try {
					conn = DBUtil.makeConnection();
					String sql = "delete from product where id = ?";
					ps = conn.prepareStatement(sql);
					
					ps.setInt(1, id);
					ps.executeUpdate();
				} finally {
					DBUtil.closeRegister(conn, ps);
				}
			}
			
			public int getTotalProduct() {
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
					conn = DBUtil.makeConnection();
					String sql = "select count(*) from product";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					while (rs.next()) {
						return rs.getInt(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBUtil.close(conn, ps, rs);
				}
				return 0;
			}
			
			public ProductDTO getProducDTOtById (String id) throws Exception {
				ProductDTO product = null;
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				try {
					conn = DBUtil.makeConnection();
					String sql = "select product.*, category.name as category_name, category.description as category_description from product join category on product.category_id = category.id where product.id = ?";
					
					ps = conn.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(id));
					rs = ps.executeQuery();
					
					if (rs.next()) {
						String name = rs.getString("name");
						String size = rs.getString("size");
						String color = rs.getString("color");
						String production_country = rs.getString("production_country");
						String materials = rs.getString("materials");
						String description = rs.getString("description");
						float price = rs.getFloat("price");
						int category_id = rs.getInt("category_id");
						String brand = rs.getString("brand");
						String image = rs.getString("image");
						String categoryName = rs.getString("category_name");
						String categoryDescription = rs.getString("category_description");
						product = new ProductDTO(Integer.parseInt(id), name, size, color, production_country, materials, description, price, dataUtil.convertImage(image), category_id, brand, categoryName, categoryDescription);
					} else {
						throw new Exception("Cannot find product with value id: " + id);
					}
					return product;
				} finally {  
					DBUtil.close(conn, ps, rs);
				}
			
		}
		
}
