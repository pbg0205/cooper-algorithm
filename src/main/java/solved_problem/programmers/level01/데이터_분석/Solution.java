package solved_problem.programmers.level01.데이터_분석;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Solution {
	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		List<Data> dataList = new ArrayList<>();
		for (int[] datum : data) {
			final int code = datum[0];
			final LocalDate date = toLocalDate(datum[1]);
			final int maximum = datum[2];
			final int remain = datum[3];

			dataList.add(new Data(code, date, maximum, remain));
		}

		Predicate<Data> predicate = getPredicateByCondition(ext, val_ext);
		Comparator<Data> comparator = getComparatorByCondition(sort_by);

		final List<Data> extractions = dataList.stream()
			.filter(Objects.requireNonNull(predicate))
			.sorted(comparator)
			.collect(Collectors.toList());

		return transformResult(extractions);
	}

	private int[][] transformResult(final List<Data> extractions) {
		int[][] result = new int[extractions.size()][4];
		for (int i = 0; i < extractions.size(); i++) {
			final Data dataUnit = extractions.get(i);
			result[i] = new int[]{dataUnit.code, localDateToInt(dataUnit.date), dataUnit.maximum, dataUnit.remain};
		}
		return result;
	}

	private Comparator<Data> getComparatorByCondition(final String standard) {
		switch (standard) {
			case "code":
				return Comparator.comparingInt(a -> a.code);
			case "date":
				return Comparator.comparing(a -> a.date);
			case "maximum":
				return Comparator.comparing(a -> a.maximum);
			default:
				return Comparator.comparing(a -> a.remain);
		}
	}

	private static Predicate<Data> getPredicateByCondition(final String ext, final int val_ext) {
		switch (ext) {
			case "code":
				return (dataUnit) -> dataUnit.code < val_ext;
			case "date":
				return (dataUnit) -> dataUnit.date.isBefore(toLocalDate(val_ext));
			case "maximum":
				return (dataUnit) -> dataUnit.maximum < val_ext;
			case "remain":
				return (dataUnit) -> dataUnit.remain < val_ext;
		}

		return null;
	}

	private int localDateToInt(final LocalDate date) {
		String value = date.getYear()+ "" +
			(date.getMonth().getValue() < 10 ? "0" + date.getMonth().getValue() : date.getMonth().getValue()) +
			(date.getDayOfMonth() < 10 ? "0" + date.getDayOfMonth() : date.getDayOfMonth());

		return Integer.parseInt(value);
	}

	private static LocalDate toLocalDate(final int data) {
		return LocalDate.parse(String.valueOf(data), DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

	static class Data {
		private final int code;
		private final LocalDate date;
		private final int maximum;
		private final int remain;

		public Data(final int code, final LocalDate date, final int maximum, final int remain) {
			this.code = code;
			this.date = date;
			this.maximum = maximum;
			this.remain = remain;
		}
	}
}
