package kd.com

import kd.com.qualifiers.MaxNumber
import kd.com.qualifiers.MinNumber
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class NumberGeneratorImpl(
    @MaxNumber private var maxNumber: Int,
    @MinNumber private var minNumber: Int
) : NumberGenerator {

    private val random = Random()

    override fun getMaxNumber(): Int {
        return maxNumber
    }

    override fun getMinNumber(): Int {
        return minNumber
    }

    override fun nextNumber(): Int {
        return random.nextInt(maxNumber)
    }
}