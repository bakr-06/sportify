package com.example.sportify.match_list_screen.presentation.components
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import coil3.compose.AsyncImage
//import com.example.sportify.R
//import com.example.sportify.core.presentation.theme.ui.manropeFontFamily
//import com.example.sportify.match_list_screen.presentation.UpcomingMatchUi
//import com.example.sportify.match_list_screen.presentation.upcomingMatchUiPreviewItem
//
//@Composable
//fun PastMatchesListItem(
//    match: UpcomingMatchUi,
//    modifier: Modifier = Modifier,
//) {
//    Surface(
//        modifier = modifier,
//        color = Color(0xFFEEEDED),
//        onClick = { }
//    ) {
//        Column {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp, vertical = 36.dp),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Row(
//                    modifier = Modifier,
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.spacedBy(12.dp)
//                ) {
//                    Text(
//                        text = match.homeTeam.shortName,
//                        fontFamily = manropeFontFamily,
//                        fontWeight = FontWeight.SemiBold,
//                        fontSize = 14.sp
//                    )
//                    Spacer(modifier = Modifier.width(4.dp))
//                    AsyncImage(
//                        model = match.homeTeam.crest,
//                        placeholder = painterResource(R.drawable.arsenal),
//                        contentDescription = null,
//                        modifier = Modifier.size(40.dp)
//                    )
//                    Text(
//                        text = "${match.score.home}",
//                        fontFamily = manropeFontFamily,
//                        fontWeight = FontWeight.SemiBold,
//                        fontSize = 24.sp,
//                    )
//                }
//                Row(
//                    modifier = Modifier,
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.spacedBy(12.dp)
//                ) {
//                    Text(
//                        text = "${match.score.away}",
//                        fontFamily = manropeFontFamily,
//                        fontWeight = FontWeight.SemiBold,
//                        fontSize = 24.sp,
//                    )
//                    Spacer(modifier = Modifier.width(4.dp))
//                    AsyncImage(
//                        model = match.awayTeam.crest,
//                        placeholder = painterResource(R.drawable.arsenal),
//                        contentDescription = null,
//                        modifier = Modifier.size(40.dp)
//                    )
//                    Text(
//                        text = match.awayTeam.shortName,
//                        fontFamily = manropeFontFamily,
//                        fontWeight = FontWeight.SemiBold,
//                        fontSize = 14.sp
//                    )
//                }
//            }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(Color(0xFF1E1E1E))
//                    .padding(horizontal = 16.dp, vertical = 8.dp),
//            ) {
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Row(
//                        modifier = Modifier,
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.spacedBy(12.dp)
//                    ) {
//                        Box(
//                            modifier = Modifier
//                                .background(Color.White)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Icon(
//                                painter = painterResource(R.drawable.premier_league),
//                                contentDescription = null
//                            )
//                        }
//                        Text(
//                            text = "LEAGUE MATCH",
//                            fontFamily = manropeFontFamily,
//                            fontWeight = FontWeight.SemiBold,
//                            fontSize = 14.sp,
//                            color = Color.White
//                        )
//                    }
//                    Icon(
//                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
//                        contentDescription = null,
//                        tint = Color(0xFFFAFAFA)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun PastMatchesItemListPreview() {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        PastMatchesListItem(upcomingMatchUiPreviewItem)
//    }
//
//}