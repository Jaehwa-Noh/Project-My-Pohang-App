//
//  RecommendDetailView.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

import SwiftUI

struct RecommendDetailView: View {
    let recommend: Recommend?
    
    var body: some View {
        if recommend != nil {
            GeometryReader { geometry in
                VStack {
                    Image(recommend!.picture)
                        .resizable()
                        .scaledToFill()
                        .frame(width: geometry.size.width, height: geometry.size.height / 3)
                        .clipped()
                    RecommendDetailTextAreaView(recommend: recommend!)
                    Spacer()
                }
            }
        } else {
            EmptyView()
        }
    }
}

struct RecommendDetailTextAreaView: View {
    let recommend: Recommend
    var body: some View {
        ScrollView {
            VStack(alignment: .leading) {
                Text("\(recommend.name)")
                    .font(.title)
                Spacer()
                    .frame(height: 8)
                Text("\(recommend.location)")
                    .font(.subheadline)
                Spacer()
                    .frame(height: 8)
                Text("\(recommend.information)")
                    .accessibilityIdentifier("Information")
                    .font(.body)
                Spacer()
                    .frame(height: 8)
                Text("\(recommend.source)")
                    .font(.caption)
            }
            .padding(8)
        }
    }
}

#Preview {
    RecommendDetailView(
        recommend: CategoryAndRecommendRepository().recommends[0])
}
