package de.akii.commercetools.api.customtypes.plugin.gradle

import com.commercetools.api.defaultconfig.ServiceRegion
import com.commercetools.api.models.product_type.AttributeDefinition
import com.commercetools.api.models.product_type.ProductType
import com.commercetools.api.models.type.FieldDefinition
import com.commercetools.api.models.type.Type
import de.akii.commercetools.api.customtypes.generator.common.*
import org.gradle.api.Action
import java.io.File

open class CustomTypesGeneratorPluginExtension {
    private var credentialsConfigured = false
    internal val credentialsExtension: Credentials by lazy {
        credentialsConfigured = true
        Credentials()
    }

    private var productTypesGeneratorConfigured = false
    internal val productTypesGeneratorExtension: CustomProductTypesGeneratorConfiguration by lazy {
        productTypesGeneratorConfigured = true
        CustomProductTypesGeneratorConfiguration()
    }

    private var typesGeneratorConfigured = false
    internal val typesGeneratorExtension: CustomTypesGeneratorConfiguration by lazy {
        typesGeneratorConfigured = true
        CustomTypesGeneratorConfiguration()
    }

    var packageName: String? = null

    fun credentials(action: Action<Credentials>) {
        action.execute(credentialsExtension)
    }

    fun productTypes(action: Action<CustomProductTypesGeneratorConfiguration>) {
        action.execute(productTypesGeneratorExtension)
    }

    fun customFields(action: Action<CustomTypesGeneratorConfiguration>) {
        action.execute(typesGeneratorExtension)
    }

    internal fun credentialsConfigured(): Boolean = credentialsConfigured
    internal fun productTypesGeneratorConfigured(): Boolean = productTypesGeneratorConfigured
    internal fun typesGeneratorConfigured(): Boolean = typesGeneratorConfigured
}

open class Credentials {
    var clientId: String? = null
    var clientSecret: String? = null
    var serviceRegion: ServiceRegion? = null
    var projectName: String? = null
}

open class CustomProductTypesGeneratorConfiguration {
    var productTypesFile: File? = null
    var productTypeToClassName: (productType: ProductType, productClassType: ProductClassType) -> String = ::productTypeToClassName
    var productTypeAttributeToPropertyName: (productType: ProductType, attribute: AttributeDefinition) -> String = ::productTypeAttributeToPropertyName
}

open class CustomTypesGeneratorConfiguration {
    var typesFile: File? = null
    var fieldDefinitionToPropertyName: (type: Type, fieldDefinition: FieldDefinition) -> String = ::fieldDefinitionToPropertyName
}