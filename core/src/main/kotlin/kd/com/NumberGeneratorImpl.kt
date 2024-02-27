package kd.com

import kd.com.qualifiers.MaxNumber
import kd.com.qualifiers.MinNumber
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class NumberGeneratorImpl : NumberGenerator {

    private val random = Random()

    private var maxNumber: Int
    private var minNumber: Int

    @Autowired
    constructor(@MaxNumber maxNumber: Int,@MinNumber minNumber: Int) {
        this.maxNumber = maxNumber
        this.minNumber = minNumber
    }

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