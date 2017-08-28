package com.bms.reader.util;

public class TransformToColumn {
	public static String transfromToBookColumn(String str)
	{
		if("bookId".equals(str))
			return "BOOK_ID";
		if("bookkIND".equals(str))
			return "BOOK_KIND";
		if("bookName".equals(str))
			return "BOOK_NAME";
		if("bookAuthor".equals(str))
			return "BOOK_AUTHOR";
		if("bookPubl".equals(str))
			return "BOOK_PUBL";
		if("publDate".equals(str))
			return "PUBL_DATE";
		if("bookPrice".equals(str))
			return "BOOK_PRICE";
		if("bookAddress".equals(str))
			return "BOOK_ADDRESS";
		if("storageDate".equals(str))
			return "STORAGE_DATE";
		return "BOOK_INTRO";
	}

	public static String transfromToReaderColumn(String sort) {
		if("id".equals(sort))
			return "ID";
		if("userId".equals(sort))
			return "USER_ID";
		if("readerName".equals(sort))
			return "READER_NAME";
		if("sex".equals(sort))
			return "SEX";
		if("phone".equals(sort))
			return "PHONE";
		return "EMAIL";
	}

	public static String transfromToBorrowColumn(String sort) {
		if("reocordId".equals(sort))
			return "RECORD_ID";
		if("readerId".equals(sort))
			return "READER_ID";
		if("bookId".equals(sort))
			return "BOOK_ID";
		if("startDate".equals(sort))
			return "START_DATE";
		return "END_DATE";
	}

	public static String transfromToReturnColumn(String sort) {
		if("recordId".equals(sort))
			return "RECORD_ID";
		if("readerId".equals(sort))
			return "READER_ID";
		if("bookId".equals(sort))
			return "BOOK_ID";
		if("startDate".equals(sort))
			return "START_DATE";
		return "END_DATE";
	}
}
