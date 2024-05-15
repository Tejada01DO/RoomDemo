package com.ucne.myapplication.navigation

import kotlinx.serialization.Serializable

@Serializable
object TicketScreen

@Serializable
object TicketListScreen

@Serializable
data class onVerTicket(val ticketId: Int)

@Serializable
data class onSaveTicket(val ticketId: Int, val cliente: String, val asunto: String)