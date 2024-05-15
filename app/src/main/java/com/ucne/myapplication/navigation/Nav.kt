package com.ucne.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucne.myapplication.data.local.dao.TicketDao
import com.ucne.myapplication.data.repository.TicketRepository
import com.ucne.myapplication.presentation.ticket.TicketListScreen
import com.ucne.myapplication.presentation.ticket.TicketViewModel
import com.ucne.myapplication.presentation.ticket.TicketScreen

@Composable
fun Nav() {
    val navController = rememberNavController()
    val ticketRepository = TicketRepository()

    NavHost(navController = navController, startDestination = TicketListScreen){
        composable<TicketListScreen> {
            TicketListScreen(
                viewModel = TicketViewModel(ticketRepository),
                onVerTicket = {
                }
            )
        }
        composable<TicketScreen> { backStackEntry ->
            val viewModel: TicketViewModel = viewModel()
            TicketScreen(
                viewModel = viewModel,
                onSaveTicket = { ticket ->
                    viewModel.saveTicket(ticket)
                }
            )
        }
    }
}