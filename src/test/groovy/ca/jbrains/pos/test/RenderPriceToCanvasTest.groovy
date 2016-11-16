package ca.jbrains.pos.test

import ca.jbrains.pos.Canvas
import ca.jbrains.pos.CanvasDisplay
import ca.jbrains.pos.MessageFormat
import ca.jbrains.pos.Price
import spock.lang.Specification

class RenderPriceToCanvasTest extends Specification {
    def "happy path"() {
        given:
        Canvas canvas = Mock(Canvas)
        MessageFormat messageFormat = Mock(MessageFormat)

        when:
        messageFormat.formatPrice(_) >> "::formatted price::"
        new CanvasDisplay(canvas, messageFormat).displayPrice(irrelevantPrice())

        then:
        1 * canvas.render("::formatted price::")
    }

    private Price irrelevantPrice() {
        Price.cents(762)
    }
}
