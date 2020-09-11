class DateRange(var start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            override fun next(): MyDate {
                if (!hasNext()) throw NoSuchElementException()
                val result = start
                start = start.followingDate()
                return result
            }

            override fun hasNext(): Boolean = start <= end
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}