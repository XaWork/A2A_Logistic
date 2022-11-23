package a2a.logistic.app.domain.model

data class VerifyOtpModel(
    val message: String,
    val result: Result,
    val status: String
) {
    data class Result(
        val __v: Int,
        val _id: String,
        val aadhar: String,
        val about: String,
        val acc_holder_name: Any,
        val acc_number: Any,
        val account_statement: String,
        val active: Int,
        val additional_cost1: Int,
        val additional_cost2: Int,
        val address: String,
        val bag_no: List<Any>,
        val bank_address: Any,
        val bank_name: Any,
        val branch_code: Any,
        val cargo_position: CargoPosition,
        val categories: List<Any>,
        val city: Any,
        val city2: String,
        val cod: Int,
        val cod_order_cost: Int,
        val commission: String,
        val commission_type: String,
        val communication_zipcode: String,
        val contract_end: String,
        val contract_start: String,
        val country: String,
        val created_date: String,
        val credit_limit: String,
        val customer_support_city: List<Any>,
        val date_of_join: Any,
        val date_of_releiving: Any,
        val deleted: Int,
        val delivery_boy: List<Any>,
        val delivery_city: List<Any>,
        val delivery_partner_position: DeliveryPartnerPosition,
        val device_token: String,
        val device_type: String,
        val doc1: String,
        val doc1_type: String,
        val doc2: String,
        val doc2_type: String,
        val doc3: String,
        val doc3_type: String,
        val dunning_period: String,
        val email: Any,
        val email_otp: Int,
        val father_name: String,
        val `file`: List<Any>,
        val first_time: Int,
        val full_name: String,
        val health_insurance_number: String,
        val ifsc: Any,
        val insurance_coverage: String,
        val login_active: Int,
        val lp_manager: List<Any>,
        val master: Any,
        val maximum_weight: String,
        val minimum_guranteed: String,
        val mobile: String,
        val monthly_fixed_cost: String,
        val note: String,
        val office: Any,
        val otp: Int,
        val pan: String,
        val password: String,
        val pickup_boy_position: PickupBoyPosition,
        val pickup_time: String,
        val post: String,
        val present_address: String,
        val price_per_kg: String,
        val price_per_pack: String,
        val profile_image: String,
        val rate_per_km: String,
        val reffer_by: String,
        val role: Any,
        val salary: String,
        val seo_desc: String,
        val seo_title: String,
        val service_zipcode: String,
        val slug: String,
        val state: String,
        val subscription: Subscription,
        val token1: String,
        val token2: String,
        val update_date: String,
        val user_type: String,
        val vendor_position: VendorPosition,
        val zipcode: String
    ) {
        data class CargoPosition(
            val coordinates: List<Int>,
            val type: String
        )

        data class DeliveryPartnerPosition(
            val coordinates: List<Int>,
            val type: String
        )

        data class PickupBoyPosition(
            val coordinates: List<Int>,
            val type: String
        )

        data class Subscription(
            val exp_date: String,
            val key: Any,
            val plan: String,
            val point: Int,
            val updated: String
        )

        data class VendorPosition(
            val coordinates: List<Int>,
            val type: String
        )
    }
}