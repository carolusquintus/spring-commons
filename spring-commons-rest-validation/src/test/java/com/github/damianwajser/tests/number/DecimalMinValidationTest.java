package com.github.damianwajser.tests.number;

import com.github.damianwajser.model.number.DecimalMinInclusiveObject;
import com.github.damianwajser.model.number.DecimalMinObject;
import org.junit.Test;

import java.math.BigDecimal;

import static com.github.damianwajser.TestUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DecimalMinValidationTest {

	@Test
	public void min_bigDecimalInclusive() throws Exception {
		assertThat(validationFor(new DecimalMinInclusiveObject()), fails());
		assertThat(validationFor(new DecimalMinInclusiveObject(new BigDecimal("-1.0"))), fails());
		assertThat(validationFor(new DecimalMinInclusiveObject(new BigDecimal("-1"))), fails());
		assertThat(validationFor(new DecimalMinInclusiveObject(new BigDecimal("0.0"))), succedes());
		assertThat(validationFor(new DecimalMinInclusiveObject(new BigDecimal("23.00"))), succedes());
		assertThat(validationFor(new DecimalMinInclusiveObject(new BigDecimal("0.50"))), succedes());
	}

	@Test
	public void min_bigDecimalInclusiveFalse() throws Exception {
		assertThat(validationFor(new DecimalMinObject()), fails());
		assertThat(validationFor(new DecimalMinObject(new BigDecimal("-1.0"))), fails());
		assertThat(validationFor(new DecimalMinObject(new BigDecimal("-1"))), fails());
		assertThat(validationFor(new DecimalMinObject(new BigDecimal("0.0"))), fails());
		assertThat(validationFor(new DecimalMinObject(new BigDecimal("23.00"))), succedes());
		assertThat(validationFor(new DecimalMinObject(new BigDecimal("0.50"))), succedes());
	}
}
