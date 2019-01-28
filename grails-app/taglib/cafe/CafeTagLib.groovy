package cafe

class CafeTagLib {
    static defaultEncodeAs = [taglib: 'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = 'cf'

    def springSecurityService

    ProductService productService

    def currentUserProps = { attrs ->
        def user = springSecurityService.getCurrentUser()
        if (user) {
            if (attrs.username) {
                out << user.username
            } else if (attrs.role) {
                out << user.role
            }
        }
    }
    def productlist = { attrs ->
        def writer = getOut()

        List<Product> products = productService.list(params)
        writer << '<select>'
        for (Product product in products) {
            out << """
<a href="${g.createLink(controller: "test", action: "show")}" class="btn btn-success">Test</a>
"""
            writer << '<option value="'
            writer << product.id

            writer << '">'
            writer << product.id
            writer << '</option>'
        }

        writer << '</select>'
    }
}

