package com.devstoriesafrica.devstoriesafrica.models

data class GetEventsResponse(
    val events: List<EventX>,
    val pagination: Pagination
)

data class EventX(
    val capacity: Int,
    val capacity_is_custom: Boolean,
    val category_id: String,
    val changed: String,
    val created: String,
    val currency: String,
    val description: Description,
    val end: End,
    val facebook_event_id: Any,
    val format_id: String,
    val hide_end_date: Boolean,
    val hide_start_date: Boolean,
    val id: String,
    val inventory_type: String,
    val invite_only: Boolean,
    val is_externally_ticketed: Boolean,
    val is_free: Boolean,
    val is_locked: Boolean,
    val is_reserved_seating: Boolean,
    val is_series: Boolean,
    val is_series_parent: Boolean,
    val listed: Boolean,
    val locale: String,
    val logo: Logo,
    val logo_id: String,
    val name: Name,
    val online_event: Boolean,
    val organization_id: String,
    val organizer_id: String,
    val privacy_setting: String,
    val published: String,
    val resource_uri: String,
    val shareable: Boolean,
    val show_colors_in_seatmap_thumbnail: Boolean,
    val show_pick_a_seat: Boolean,
    val show_remaining: Boolean,
    val show_seatmap_thumbnail: Boolean,
    val source: String,
    val start: Start,
    val status: String,
    val subcategory_id: Any,
    val summary: String,
    val tx_time_limit: Int,
    val url: String,
    val venue_id: Any,
    val version: Any
)

data class Pagination(
    val has_more_items: Boolean,
    val object_count: Int,
    val page_count: Int,
    val page_number: Int,
    val page_size: Int
)

data class Description(
    val html: String,
    val text: String
)

data class Name(
    val html: String,
    val text: String
)

data class End(
    val local: String,
    val timezone: String,
    val utc: String
)

data class Logo(
    val aspect_ratio: String,
    val crop_mask: CropMask,
    val edge_color: String,
    val edge_color_set: Boolean,
    val id: String,
    val original: Original,
    val url: String
)

data class CropMask(
    val height: Int,
    val top_left: TopLeft,
    val width: Int
)

data class Original(
    val height: Int,
    val url: String,
    val width: Int
)

data class Start(
    val local: String,
    val timezone: String,
    val utc: String
)

data class TopLeft(
    val x: Int,
    val y: Int
)